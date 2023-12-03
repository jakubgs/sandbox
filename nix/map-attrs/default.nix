{ pkgs ? import /home/jakubgs/work/nixpkgs { } }:

#let
#  url = "${dep.host}/${dep.path}/${filename}";
#  pom = {
#    sha1 = attrByPath [ "pom" "sha1" ] "" dep;
#    sha256 = attrByPath [ "pom" "sha256" ] "" dep;
#  };
#in ''
#''
#)

let
  inherit (pkgs.lib) importJSON mapAttrsToList concatMapStrings concatStrings attrByPath;
  deps = importJSON ./data.json;
in
  (concatMapStrings (dep: concatStrings
    (mapAttrsToList (filename: hashes: ''
      ls -l ${filename}
      echo wat
    '') dep.files)
  ) deps)
