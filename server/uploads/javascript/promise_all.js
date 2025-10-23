const fs = require('fs').promises;

async function readMultipleFiles(){
    try{
        const files = ['./data/a.txt','./data/b.txt','./data/c.txt'];
        const contents = await Promise.all(files.map(f => fs.readFile(f, 'utf-8')));

        console.log('모든 파일 읽기 완료');
        contents.forEach((text,i)=>{
            console.log(`${files[i]} 내용 : `, txt);
        });
    }catch(err){
        console.error("파일중 하나라도 없으면 중단",err.message);
    }
}
readMultipleFiles();
// 여러 설정 파일(JSON, YAML 등)을 동시에 읽어 서버 환경 구성

// 여러 API 요청을 동시에 보내 결과를 합쳐서 처리