#Usages
#make : compiles all .java
#make clean : remove ALL binaries

.PHONY : all clean

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
BINS := $(SRCS:%.java=%)

all: $(BINS)

%.class: %.java
	$(LD) $(LDFLAGS) $<  


#Not sure if it works but is intented to start a command line version of the executables to test them
test :
	java $(BINS)

run:
	java $<

clean:
	@echo "Cleaning up..."
	$(RM) $(BINS)
