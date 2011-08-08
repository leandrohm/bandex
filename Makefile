#Compilacao do Projeto bandex
#Criado por: Leandro Henrique Mendes

MANIFEST=config/MANIFEST.MF


all: compile jar
	
compile:
	mkdir classes
	javac -d classes src/*.java

jar:
	jar cvfm dist/bandex.jar $(MANIFEST) -C classes/ .

clean:
	rm -rf classes
	rm -rf dist/bandex.jar
