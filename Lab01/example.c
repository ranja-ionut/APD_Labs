#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

// TASK 2
#define NUM_THREADS (sysconf(_SC_NPROCESSORS_CONF))

void *f(void *arg) {
  	long id = *(long*) arg;
	int i;

	// TASK 3
	for (i = 1; i <= 100; i++) {
		printf("Hello World din thread-ul %ld, iteratia %i!\n", id, i);
	}

  	pthread_exit(NULL);
}

void *g(void *arg) {
	char *name = (char*) arg;

	printf("Numele meu este %s!\n", name);

	pthread_exit(NULL);
}

void *h(void *arg) {
	long id = *(long*) arg;
	long sum = 0;

	printf("Am apelat functia h din thread-ul cu argumentul %li.\n", id);

	for (int i = 0; i < id; i++) {
		sum += 10;
	}

	printf("Am adaugat 10 de %li ori si am obtinut %li.\n", id, sum);

	pthread_exit(NULL);
}

int main(int argc, char *argv[]) {
	pthread_t threads[NUM_THREADS], tg, th;
  	int r;
  	long id;
  	void *status;
  	long arguments[NUM_THREADS];

  	for (id = 0; id < NUM_THREADS; id++) {
  		arguments[id] = id;
		r = pthread_create(&threads[id], NULL, f, &arguments[id]);

		if (r) {
	  		printf("Eroare la crearea thread-ului %ld\n", id);
	  		exit(-1);
		}
  	}

  	for (id = 0; id < NUM_THREADS; id++) {
		r = pthread_join(threads[id], &status);

		if (r) {
	  		printf("Eroare la asteptarea thread-ului %ld\n", id);
	  		exit(-1);
		}
  	}

	// TASK 4

	r = pthread_create(&tg, NULL, g, "Ecaterentiu");

	if (r) {
	  	printf("Eroare la crearea thread-ului tg\n");
		exit(-1);
	}

	int val = 23;

	r = pthread_create(&th, NULL, h, &val);

	if (r) {
	  	printf("Eroare la crearea thread-ului th\n");
		exit(-1);
	}

  	pthread_exit(NULL);
}
