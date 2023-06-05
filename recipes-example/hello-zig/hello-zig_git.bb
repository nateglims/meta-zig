SUMMARY = ""
HOMEPAGE = ""
DESCRIPTION = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = " \
    file://src \
    file://build.zig \
    file://LICENSE \
    "

S = "${WORKDIR}"

inherit zig

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/zig-out/bin/hello ${D}${bindir}/
}
