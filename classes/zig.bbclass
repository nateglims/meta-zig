DEPENDS:prepend = "zig-native "
B = "${WORKDIR}/build"

ZIG = "zig"

ZIG_ARGS = "--verbose "

def get_zig_target(d):
    os = "linux"
    arch = d.getVar('TARGET_ARCH')
    libc = d.getVar('TCLIBC')

    if libc == "glibc":
        libc = "gnu"
    elif libc == "musl":
        libc = "musl"

    return "-".join([arch, os, libc])
        
ZIG_TARGET ?= "${@get_zig_target(d)}"

zig_do_compile() {
    bbnote ${ZIG} build install "$@" -Dtarget=${ZIG_TARGET} ${ZIG_ARGS}
    ${ZIG} build install "$@" -Dtarget=${ZIG_TARGET} ${ZIG_ARGS}
}

EXPORT_FUNCTIONS do_compile
