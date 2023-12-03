VERSION ?= $(shell echo 4.3 >&2 )
CURRENT ?= $(shell make --version | head -n1 | cut -d' ' -f3)

test:
ifneq ($(VERSION),$(CURRENT))
	$(error Wrong version! $(VERSION) != $(CURRENT))
else
	$(info OK)
endif
