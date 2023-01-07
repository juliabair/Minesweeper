
CLASSES = \
	Grid.java \
	MineSquare.java \
	MineSweeperDriver.java \
	Minesweeper.java \
	NumberSquare.java \
	Square.java

all:
	@javac ${CLASSES} && \
	java Minesweeper

clean:
	@rm -f *.class

