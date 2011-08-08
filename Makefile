#Compilacao do Projeto bandex
#Criado por: Leandro Henrique Mendes

MANIFEST=config/MANIFEST.MF


all: compile jar
	
compile:
	javac -d classes src/*.java

jar:
	jar cvfm dist/bandex.jar $(MANIFEST) -C classes/ .

clean:
	rm -rf classes/*.class
	rm -rf bandex.jar
