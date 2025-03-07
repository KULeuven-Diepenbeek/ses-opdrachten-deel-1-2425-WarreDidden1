MAIN = app.py
TARGET = friendshiptester.bin

compile:
	@echo "Compiling ..."
	pyinstaller --onefile --name $(TARGET) $(MAIN)
	@echo "Done compiling."

clean:
	@echo "Cleaning ..."
	-rm -rf ./build ./dist ./$(TARGET) *.spec
	@echo "Done cleaning."

test: 
	python3 $(MAIN)

run: 
	@cd ./dist && ./$(TARGET)
