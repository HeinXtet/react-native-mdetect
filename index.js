import { NativeModules } from "react-native";

async function isUnicode() {
  return NativeModules.MDetect.isUnicode();
}

const MDetect = {
  isUnicode,
};

module.exports = MDetect;
