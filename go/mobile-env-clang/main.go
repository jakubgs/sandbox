package main

import (
	"fmt"
	"os/exec"
	"strings"
)

const buildN bool = false

func getAbsolutePath(output []byte) (path string) {
	for _, line := range strings.Split(string(output), "\n") {
		if strings.HasPrefix(line, "/") {
			return line
		}
	}
	return ""
}

func envClang(sdkName string) (clang, cflags string, err error) {
	if buildN {
		return sdkName + "-clang", "-isysroot " + sdkName, nil
	}
	cmd := exec.Command("xcrun", "--sdk", sdkName, "--find", "clang")
	out, err := cmd.CombinedOutput()
	if err != nil {
		return "", "", fmt.Errorf("xcrun --find: %v\n%s", err, out)
	}
	clang = getAbsolutePath(out)

	cmd = exec.Command("xcrun", "--sdk", sdkName, "--show-sdk-path")
	out, err = cmd.CombinedOutput()
	if err != nil {
		return "", "", fmt.Errorf("xcrun --show-sdk-path: %v\n%s", err, out)
	}
	sdk := getAbsolutePath(out)
	return clang, "-isysroot " + sdk, nil
}

func main() {
	clang, cflags, err := envClang("macosx")
	fmt.Println(clang)
	fmt.Println(cflags)
	fmt.Println(err)
}
