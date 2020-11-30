# react-native-mdetect

Library help to check android device font , device is unicode or zawgyi font.
Base on the MDetect by Myat Min Soe (Android Project) and using some logic to detect for unicode and zawgyi font.

## Install

```ruby
npm i react-native-mdetect
```

## Usage

`import {isUnicode} from 'react-native-mdetect';`

```ruby
isUnicode().then((value) => {
      console.log('is Unicode device ?? ' + value);
 });
```
