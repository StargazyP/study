const fs = require('fs');
const path = require('path');

// readFile Promise 버전
const readFileAsync = (filePath) => {
  return new Promise((resolve, reject) => {
    fs.readFile(filePath, (err, data) => {
      if (err) return reject(err);
      resolve(data);
    });
  });
};

// writeFile Promise 버전
const writeFileAsync = (filePath, data) => {
  return new Promise((resolve, reject) => {
    fs.writeFile(filePath, data, (err) => {
      if (err) return reject(err);
      resolve();
    });
  });
};

// chmod Promise 버전
const chmodAsync = (filePath, mode) => {
  return new Promise((resolve, reject) => {
    fs.chmod(filePath, mode, (err) => {
      if (err) return reject(err);
      resolve();
    });
  });
};

// 백업 파일 이름
const backupFile = `${__filename}-${Date.now()}`;

// 실행 흐름
readFileAsync(__filename)
  .then((data) => writeFileAsync(backupFile, data))
  .then(() => chmodAsync(backupFile, 0o400))
  .then(() => console.log(`Backup created: ${backupFile}`))
  .catch((err) => console.error('Error:', err));
