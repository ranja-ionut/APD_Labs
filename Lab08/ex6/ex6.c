#include "mpi.h"
#include <stdio.h>
#include <stdlib.h>

#define GROUP_SIZE 4
#define TAG 1

int main (int argc, char *argv[])
{
    int old_size, new_size;
    int old_rank, new_rank;
    int recv_rank;
    MPI_Comm custom_group;

    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &old_size); // Total number of processes.
    MPI_Comm_rank(MPI_COMM_WORLD, &old_rank); // The current process ID / Rank.

    // Split the MPI_COMM_WORLD in small groups.
    MPI_Comm_split(MPI_COMM_WORLD, old_rank / GROUP_SIZE, old_rank % GROUP_SIZE, &custom_group);

    MPI_Comm_size(custom_group, &new_size); // Total number of processes.
    MPI_Comm_rank(custom_group, &new_rank); // The current process ID / Rank.

    printf("Rank [%d] / size [%d] in MPI_COMM_WORLD and rank [%d] / size [%d] in custom group.\n",
            old_rank, old_size, new_rank, new_size);

    if (new_rank == 0) {
        MPI_Send(&new_rank, 1, MPI_INT, new_rank + 1, TAG, custom_group);
        MPI_Recv(&recv_rank, 1, MPI_INT, new_size - 1, TAG, custom_group, MPI_STATUS_IGNORE);
    } else if (new_rank == new_size - 1) {
        MPI_Recv(&recv_rank, 1, MPI_INT, new_rank - 1, TAG, custom_group, MPI_STATUS_IGNORE);
        MPI_Send(&new_rank, 1, MPI_INT, 0, TAG, custom_group);
    } else {
        MPI_Recv(&recv_rank, 1, MPI_INT, new_rank - 1, TAG, custom_group, MPI_STATUS_IGNORE);
        MPI_Send(&new_rank, 1, MPI_INT, new_rank + 1, TAG, custom_group);
    }

    printf("Process [%d] from group [%d] received [%d].\n", new_rank,
            old_rank / GROUP_SIZE, recv_rank);

    MPI_Finalize();
}

