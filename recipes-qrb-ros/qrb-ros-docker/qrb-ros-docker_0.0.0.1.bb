inherit ros_distro_${ROS_DISTRO} pkgconfig
inherit robotics-package

DESCRIPTION = "Provide the docker image for running and developing QRB ROS Jazzy packages"
AUTHOR = "Na Song <quic_nasong@quicinc.com>"
ROS_AUTHOR = "Na Song"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

ROS_CN = "qrb_ros_docker"
ROS_BPN = "qrb_ros_docker"

SRC_URI = "git://github.com/qualcomm-qrb-ros/qrb_ros_docker.git;protocol=https;branch=stable/1.0.0"
SRCREV = "ec667658c0ad9c329fc19622dd65d336cd718f86"
S = "${WORKDIR}/git/"

do_install() {
    install -d ${D}${datadir}/qrb_ros_docker/dockerfile
    install -d ${D}${datadir}/qrb_ros_docker/scripts

    cp -r ${S}/dockerfile/* ${D}${datadir}/qrb_ros_docker/dockerfile/
    cp -r ${S}/scripts/* ${D}${datadir}/qrb_ros_docker/scripts/
}

FILES_${PN} += "${datadir}/qrb_ros_docker/dockerfile \
                ${datadir}/qrb_ros_docker/scripts"

inherit robotics-package
