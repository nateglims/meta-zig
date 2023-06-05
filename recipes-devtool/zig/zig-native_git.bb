# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   deps/SoftFloat-3e/COPYING.txt
#   lib/libc/glibc/LICENSES
#   lib/libc/mingw/COPYING
#   lib/libc/musl/COPYRIGHT
#   lib/libc/wasi/LICENSE
#   lib/libc/wasi/LICENSE-APACHE
#   lib/libc/wasi/LICENSE-APACHE-LLVM
#   lib/libc/wasi/libc-bottom-half/cloudlibc/LICENSE
#   lib/libc/wasi/libc-top-half/musl/COPYRIGHT
#   lib/libcxx/LICENSE.TXT
#   lib/libcxxabi/LICENSE.TXT
#   lib/libunwind/LICENSE.TXT
#   tools/update-license-headers.zig
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "MIT & Unknown"
LIC_FILES_CHKSUM = "file://LICENSE;md5=76fa81457eac3505dbbe2fb4372e393e \
                    file://deps/SoftFloat-3e/COPYING.txt;md5=0b6137168c63647384f5a0f8ac006dfb \
                    file://lib/libc/glibc/LICENSES;md5=1541fd8f5e8f1579512bf05f533371ba \
                    file://lib/libc/mingw/COPYING;md5=bb936f0e04d8f1e19ad545100cee9654 \
                    file://lib/libc/musl/COPYRIGHT;md5=b03f1cc25363d094011f8f4fd8bcfb68 \
                    file://lib/libc/wasi/LICENSE;md5=2b393aadf48c3c4851d44b660df7b20f \
                    file://lib/libc/wasi/LICENSE-APACHE;md5=1836efb2eb779966696f473ee8540542 \
                    file://lib/libc/wasi/LICENSE-APACHE-LLVM;md5=a1ba2b4c4f909ac0b517d8a37d2ac70f \
                    file://lib/libc/wasi/LICENSE-MIT;md5=b377b220f43d747efdec40d69fcaa69d \
                    file://lib/libc/wasi/libc-bottom-half/cloudlibc/LICENSE;md5=dfa4a358398d1a4cec792f994c787415 \
                    file://lib/libc/wasi/libc-top-half/musl/COPYRIGHT;md5=b03f1cc25363d094011f8f4fd8bcfb68 \
                    file://lib/libcxx/LICENSE.TXT;md5=55d89dd7eec8d3b4204b680e27da3953 \
                    file://lib/libcxxabi/LICENSE.TXT;md5=7b9334635b542c56868400a46b272b1e \
                    file://lib/libunwind/LICENSE.TXT;md5=f66970035d12f196030658b11725e1a1 \
                    file://tools/update-license-headers.zig;md5=48ab19cd3ae8d1a4d708f795fb7b4374"

SRC_URI = "git://github.com/ziglang/zig.git;branch=0.10.x;protocol=https"

# Modify these as desired
PV = "0.10.1"
SRCREV = "b57081f039bd3f8f82210e8896e336e3c3a6869b"

S = "${WORKDIR}/git"
B = "${S}/build"

# NOTE: unable to map the following CMake package dependencies: llvm lld clang
# NOTE: the following library dependencies are unknown, ignoring: libcurses libzstd libz
#       (this is based on recipes that have previously been built and packaged)
inherit cmake native

do_compile() {
    make install
}
    
DEPENDS = "llvm-native clang"

EXTRA_OECMAKE = "-DCMAKE_BUILD_TYPE=Release"

OECMAKE_GENERATOR = "Unix Makefiles"

# Use this in distro:
# LLVM_TARGETS_TO_BUILD = "AArch64;AMDGPU;ARM;AVR;BPF;Hexagon;Lanai;Mips;MSP430;NVPTX;PowerPC;RISCV;Sparc;SystemZ;VE;WebAssembly;X86;XCore"
