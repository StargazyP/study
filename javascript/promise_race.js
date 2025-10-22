const fakeFetc = (url,delay,shouldFail = false)=> new Promise((resolve,reject)=>{
    setTimeout(()=>{
        if(shouldFail){
            reject(`${url}실패`);

        }else{
            resolve(`${url}응답 (지연 : ${delay}ms)`);
        }
    },delay);
});

async function fetchFastestServer(){
    const server = [
        fakeFetc('serverA', 1200),
        fakeFetc('serverB',800),
        fakeFetc('serverC', 1000)
    ];
    try{
        const fastest = await Promise.race(server);
        console.log('가장 빠른 서버 ', fastest);
    }catch(err){
        console.error('가장 먼서 실패한 서버 ', err);
        }
}
fetchFastestServer();
//여러 CDN, API 엔드포인트 중 가장 빠른 서버 선택

//백업 서버 로드 밸런싱 (최초 성공 응답 사용)