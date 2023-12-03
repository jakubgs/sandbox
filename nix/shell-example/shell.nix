{ pkgs ? import ../../work/nixpkgs { } }:

pkgs.mkShell {
  name = "just-a-test-shell";
  buildInputs = with pkgs; [ htop ];
}
