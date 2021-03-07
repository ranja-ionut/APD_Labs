JAVAFLAGS=-Xmx4096m -Xss1024m

EX1 = oneProducerOneConsumer
EX2 = multipleProducersMultipleConsumersNBuffer
EX3 = philosophersProblem
EX4 = parallelBinarySearch

build: ex1 ex2 ex3 ex4

ex1:
	javac ${EX1}/Main.java ${EX1}/Buffer.java ${EX1}/Consumer.java ${EX1}/Producer.java

ex2:
	javac ${EX2}/Main.java ${EX2}/Buffer.java ${EX2}/Consumer.java ${EX2}/Producer.java ${EX2}/LimitedQueue.java 
	
ex3:
	javac ${EX3}/Main.java ${EX3}/Philosopher.java

ex4:
	javac ${EX4}/Main.java ${EX4}/MyTask.java

run-ex1:
	@java ${JAVAFLAGS} ${EX1}/Main

run-ex2:
	@java ${JAVAFLAGS} ${EX2}/Main

run-ex3:
	@java ${JAVAFLAGS} ${EX3}/Main

run-ex4:
	@java ${JAVAFLAGS} ${EX4}/Main

run:
	@echo "Output Ex1:\n"
	@make run-ex1 --no-print-directory
	@echo ""
	@echo "Output Ex2:\n"
	@make run-ex2 --no-print-directory
	@echo ""
	@echo "Output Ex3:\n"
	@make run-ex3 --no-print-directory
	@echo ""
	@echo "Output Ex4:\n"
	@make run-ex4 --no-print-directory

clean:
	rm -f *.class ./*/*.class
