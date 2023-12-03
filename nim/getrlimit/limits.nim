from posix import getrlimit, RLIMIT_NOFILE, RLimit

var limits = RLimit()
var rval = getrlimit(RLIMIT_NOFILE, limits)
echo "file limits: ", limits
