DESCRIPTION = "Sensor service"
LICENSE          = "Qualcomm-Technologies-Inc.-Proprietary"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}/${LICENSE};md5=58d50a3d36f27f1a1e6089308a49b403"

DEPENDS += "glib-2.0 property-vault"
DEPENDS += "qmi-framework"
DEPENDS += "protobuf"
DEPENDS += "protobuf-native"
DEPENDS += "qcom-sensors-api"
DEPENDS += "qcom-sensors-utils"
DEPENDS += "qcom-sensinghub"
DEPENDS += "yaml-cpp"
DEPENDS += "libbsd"
RDEPENDS:${PN} += "yaml-cpp"

QCM6490_SHA256SUM = "e3b3c074be4a5e99133bef2d9ed8ef48d04dd0cf0ab5afa4e6813e9fe7737654"

SRC_URI[qcm6490.sha256sum] = "${QCM6490_SHA256SUM}"

SRC_URI = "${ROBOT_PBT_ARTIFACTORY}/${ROBOT_PBT_BUILD_ID}/${ROBOT_PBT_BIN_PATH}/${BPN}_${PV}_${PBT_ARCH}.tar.gz;name=${PBT_ARCH}"

S = "${WORKDIR}/sensor-service"

FILES:${PN} += "${includedir}/*"
FILES:${PN} += "/usr/lib/*"
FILES:${PN} += "/usr/bin/*"
FILES:${PN}-dev  = "${libdir}/*.la ${includedir}"
FILES:${PN} += "${sysconfdir}/sensors/*"
FILES:${PN} += "${systemd_unitdir}/system/"
FILES:${PN} += "/systemd/system/*"
RM_WORK_EXCLUDE += "${PN}"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

PACKAGE_ARCH    ?= "${SOC_ARCH}"

do_install() {
    cp -r ${WORKDIR}/etc ${D}/
    cp -r ${WORKDIR}/usr ${D}/
}

do_package_qa[noexec] = "1"
