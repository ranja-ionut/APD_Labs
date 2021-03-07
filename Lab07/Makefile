JAVAFLAGS=-Xmx4096m -Xss1024m

EX1 = src/task1
EX2 = src/task2
EX3 = src/task3
EX4 = src/task4
EX5 = src/task5
EX6 = src/task6

build: ex1 ex2 ex3 ex4 ex5 ex6

ex1:
	javac ${EX1}/Main.java ${EX1}/MyRunnable.java

ex2:
	javac ${EX2}/Main.java ${EX2}/MyRunnable.java
	
ex3:
	javac ${EX3}/Main.java ${EX3}/MyRunnable.java

ex4:
	javac ${EX4}/Main.java ${EX4}/MyTask.java

ex5:
	javac ${EX5}/Main.java ${EX5}/MyTask.java

ex6:
	javac ${EX6}/Main.java ${EX6}/MyTask.java

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

run-ex6:
	@java ${JAVAFLAGS} ${EX6}/Main

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
	@echo ""
	@echo "Output Ex6:\n"
	@make run-ex6 --no-print-directory

clean:
	rm -f ./src/*/*.class
