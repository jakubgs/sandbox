all: 1.test

1.test: 2.test 3.test
	touch 1.test
	touch 2.test
	touch 3.test

2.test:

3.test:


TEST_FILE := 1.test

file-test:
	echo "BEGINNING"
ifneq ("$(wildcard $(TEST_FILE))","")
	echo "FILE EXISTS!"
endif
ifneq ("$(wildcard $(TEST_FILE).asc)","")
	echo "ASC FILE EXISTS!"
endif
	echo "END"

FILE := pkg/test-binary
TARBALL := pkg/test-binary.tar.gz
TARBALL_FULL := $(shell realpath $(TARBALL))

tarball:
	cd $(shell dirname $(FILE)) && \
	tar czvf $(TARBALL_FULL) --ignore-failed-read \
		$(shell basename $(FILE)){,.asc}
