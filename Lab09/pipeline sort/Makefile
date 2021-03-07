build:
	mpicc pipeline_sort.c -o pipeline_sort
run1:
	mpirun -np 2 pipeline_sort > a1.txt
run2:
	mpirun -np 14 --oversubscribe pipeline_sort > a2.txt
clean:
	rm pipeline_sort
