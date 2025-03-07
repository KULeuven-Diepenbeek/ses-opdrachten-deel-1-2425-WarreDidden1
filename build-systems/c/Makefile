CC = gcc
CFLAGS = -Wall -Wextra -std=c11
SRCDIR = ./src
BUILDDIR = ./build

# Zoek alle .c bestanden in de SRCDIR
CFILES = $(wildcard $(SRCDIR)/*.c)
# Genereer de bijhorende .o bestanden in BUILDDIR
OBJECTS = $(patsubst $(SRCDIR)/%.c,$(BUILDDIR)/%.o,$(CFILES))

TARGET = friendshiptester.bin

all: $(TARGET)

# Link de objectfiles om de uiteindelijke binary te maken
$(TARGET): $(OBJECTS)
	$(CC) -o $@ $^

# Compileer de C-bestanden naar object-bestanden
$(BUILDDIR)/%.o: $(SRCDIR)/%.c | $(BUILDDIR)
	$(CC) $(CFLAGS) -c -o $@ $<

# Zorg dat de build-directory bestaat
$(BUILDDIR):
	mkdir -p $(BUILDDIR)

compile: $(TARGET)

clean:
	rm -rf $(BUILDDIR) $(TARGET)

run: $(TARGET)
	./$(TARGET) $(ARGS)
