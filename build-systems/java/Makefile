MAINCLASS = App
JAR = app.jar

compile:
	@echo "compiling ..."
	javac -d ./build $(shell find . -name "*.java")
	@echo "Done compiling."

clean:
	@echo "cleaning ..."
	-rm -R ./build/*
	@echo "Done cleaning."

run: compile
	@echo "running program $(MAINCLASS) ...\n---------------"
	@cd ./build && java $(MAINCLASS)
	@echo "---------------\nProgram exited."

jar: compile
	@echo "Packaging to jar ..."
	cd ./build && jar cvfe $(JAR) $(MAINCLASS) *
	@echo "Done packaging."

run-jar: jar
	@echo "running jar $(JAR) ...\n---------------"
	@java -jar ./build/$(JAR)
	@echo "---------------\nProgram exited."
