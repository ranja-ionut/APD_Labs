JAVAFLAGS=-Xmx4096m -Xss1024m

EX1 = src/multipleProducersMultipleConsumers
EX2 = src/synchronizationProblem
EX3 = src/bugConcurrentHashMap
EX4 = src/synchronizedSortedList
EX5 = src/parallelTree

build: ex1 ex2 ex3 ex4 ex5

ex1:
	javac ${EX1}/Main.java ${EX1}/Buffer.java ${EX1}/Consumer.java ${EX1}/Producer.java

ex2:
	javac ${EX2}/Main.java ${EX2}/MyThread.java
	
ex3:
	javac ${EX3}/Main.java ${EX3}/MyThread.java

ex4:
	javac ${EX4}/Main.java ${EX4}/Reader.java ${EX4}/Sort.java

ex5:
	javac ${EX5}/Main.java ${EX5}/ReadTreePart.java ${EX5}/TreeNode.java ${EX5}/VerifyTree.java

run-ex1:
	@java ${JAVAFLAGS} ${EX1}/Main

run-ex2:
	@java ${JAVAFLAGS} ${EX2}/Main

run-ex3:
	@java ${JAVAFLAGS} ${EX3}/Main

run-ex4:
	@java ${JAVAFLAGS} ${EX4}/Main

run-ex5:
	@java ${JAVAFLAGS} ${EX5}/Main

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
	@echo ""
	@echo "Output Ex5:\n"
	@make run-ex5 --no-print-directory

clean:
	rm -f ./src/*/*.class
