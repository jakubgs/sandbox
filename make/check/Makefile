
test: | check-test
	echo $(QTDIR) > test

check-test:
ifeq ($(QTDIR),)
	$(error Cannot find your Qt5 installation. Please run "$(MAKE) QTDIR=/path/to/your/Qt5/installation/prefix ...")
endif

clean:
	rm test
