let 
  #nixpkgs = builtins.fetchTarball {
  #  url = "https://github.com/NixOS/nixpkgs/archive/065bb60a82d9305f85ed670e9313e0cf2409395c.tar.gz";
  #  sha256 = "sha256:0mwck8jyr74wh1b7g6nac1mxy6a0rkpaz8n12andsffybsipz5jw";
  #};
  nixpkgs = builtins.fetchGit {
    url = "https://github.com/NixOS/nixpkgs.git";
    rev = "065bb60a82d9305f85ed670e9313e0cf2409395c";
    shallow = true;
  };
  pkgs = import nixpkgs { };
in pkgs.hello.version
