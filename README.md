Dependencies
============

  URI: https://github.com/kraj/meta-clang.git
  branch: mickledore

Patches
=======

Please submit changes via Pull Request

Maintainer: nateglims

Table of Contents
=================

  I. Adding the meta-zig layer to your build
 II. Misc


I. Adding the meta-zig layer to your build
=================================================

Run 'bitbake-layers add-layer meta-zig'

II. Misc
========

Add to distro/local conf:

```editor-config
LLVM_TARGETS_TO_BUILD = "AArch64;AMDGPU;ARM;AVR;BPF;Hexagon;Lanai;Mips;MSP430;NVPTX;PowerPC;RISCV;Sparc;SystemZ;VE;WebAssembly;X86;XCore"
```

III. TODO
=========
- [ ] Host Build
- [ ] zig on Target
- [ ] Cross/Canadian
- [ ] Vendor LLVM to match zig required version
- [ ] CI

