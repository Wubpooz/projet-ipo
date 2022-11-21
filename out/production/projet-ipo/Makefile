#Usages
#make : compiles all .java
#make clean : remove ALL binaries

.PHONY : all compile run clean

#Compiler
CP = javac
CFLAGS =

#Linker
LD = javac
LDFLAGS =

#Cleaner (can specify a dir in which bin would be created)
RM = rm -rvf

#Executable files retriving
SRCS := $(wildcard *.java)
BINS := $(SRCS:%.java=%.class)

all: *.java
	$(LD) $(LDFLAGS) $^ 

run:
	java Jeu

clean:
	@echo "Cleaning up..."
	$(RM) $(BINS)
