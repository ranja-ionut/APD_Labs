JAVAFLAGS=-Xmx4096m -Xss1024m

build: p1 bug1 bug2 bug3 bug4 bug5 vector short

p1: P1.java Task.java
	javac P1.java Task.java

bug1:
	javac src/bug1/Main.java src/bug1/MyThread.java
	
bug2:
	javac src/bug2/Main.java src/bug2/MyThread.java

bug3:
	javac src/bug3/Main.java src/bug3/MyThread.java

bug4:
	javac src/bug4/Main.java

bug5:
	javac src/bug5/Main.java src/bug5/MyThreadA.java src/bug5/MyThreadB.java

vector:
	javac src/doubleVectorElements/Main.java src/doubleVectorElements/Task.java

short:
	javac src/shortestPathsFloyd_Warshall/Main.java

run-p1:
	@java ${JAVAFLAGS} P1

run-bug1:
	@java ${JAVAFLAGS} src/bug1/Main

run-bug2:
	@java ${JAVAFLAGS} src/bug2/Main

run-bug3:
	@java ${JAVAFLAGS} src/bug3/Main

run-bug4:
	@java ${JAVAFLAGS} src/bug4/Main

run-bug5:
	@java ${JAVAFLAGS} src/bug5/Main

run-vector:
	@java ${JAVAFLAGS} src/doubleVectorElements/Main

run-short:
	@java ${JAVAFLAGS} src/shortestPathsFloyd_Warshall/Main

run:
	@echo "Output Ex1:\n"
	@make run-p1 --no-print-directory
	@echo ""
	@echo "Output Ex2:\n"
	@echo "Bug1:\n"
	@make run-bug1 --no-print-directory
	@echo ""
	@echo "Bug2:\n"
	@make run-bug2 --no-print-directory
	@echo ""
	@echo "Bug3:\n"
	@make run-bug3 --no-print-directory
	@echo ""
	@echo "Bug4:\n"
	@make run-bug4 --no-print-directory
	@echo ""
	@echo "Bug5:\n"
	@make run-bug5 --no-print-directory
	@echo ""
	@echo "Output Ex3:\n"
	@make run-vector --no-print-directory
	@echo ""
	@echo "Output Ex4:\n"
	@make run-short --no-print-directory

clean:
	rm -f *.class src/*/*.class
