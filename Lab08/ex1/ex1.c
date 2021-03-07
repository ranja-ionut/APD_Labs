#include "mpi.h"
#include <stdio.h>
#include <stdlib.h>

#define TAG 1

int main (int argc, char *argv[])
{
    int  numtasks, rank;

    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &numtasks);
    MPI_Comm_rank(MPI_COMM_WORLD,&rank);

    // First process starts the circle.
    if (rank == 0) {
        // First process starts the circle.
        // Generate a random number.
        srand(42);
        int x = rand() % 100;

        printf("Proces cu rangul %i, o sa trimit valoarea %i.\n", rank, x);

        // Send the number to the next process.
        MPI_Send(&x, 1, MPI_INT, rank + 1, TAG, MPI_COMM_WORLD);


        MPI_Recv(&x, 1, MPI_INT, numtasks - 1, TAG, MPI_COMM_WORLD, MPI_STATUS_IGNORE);

        printf("Proces cu rangul %i, am primit valoarea %i.\n", rank, x);
    } else if (rank == numtasks - 1) {
        // Last process close the circle.
        // Receives the number from the previous process.
        int x = 0;
        MPI_Recv(&x, 1, MPI_INT, rank - 1, TAG, MPI_COMM_WORLD, MPI_STATUS_IGNORE);

        printf("Proces cu rangul %i, am primit valoarea %i.\n", rank, x);

        // Increments the number.
        x += 2;

        // Sends the number to the first process.
        MPI_Send(&x, 1, MPI_INT, 0, TAG, MPI_COMM_WORLD);
    } else {
        // Middle process.
        // Receives the number from the previous process.
        int x = 0;
        MPI_Recv(&x, 1, MPI_INT, rank - 1, TAG, MPI_COMM_WORLD, MPI_STATUS_IGNORE);

        printf("Proces cu rangul %i, am primit valoarea %i.\n", rank, x);

        // Increments the number.
        x += 2;

        // Sends the number to the next process.
        MPI_Send(&x, 1, MPI_INT, rank + 1, TAG, MPI_COMM_WORLD);
    }

    MPI_Finalize();

}

