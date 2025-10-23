const fakeRequest = (url, delay, shouldFail = false) =>
  new Promise((resolve, reject) => {
    setTimeout(() => {
      if (shouldFail) reject(`❌ ${url} 실패`);
      else resolve(`✅ ${url} 성공`);
    }, delay);
  });

async function getAllResults() {
  const requests = [
    fakeRequest('API-1', 500),
    fakeRequest('API-2', 800, true),
    fakeRequest('API-3', 300)
  ];

  const results = await Promise.allSettled(requests);

  results.forEach((res, i) => {
    if (res.status === 'fulfilled') {
      console.log(`✅ 요청${i + 1} 성공:`, res.value);
    } else {
      console.warn(`⚠️ 요청${i + 1} 실패:`, res.reason);
    }
  });
}

getAllResults();
//여러 API 중 일부 실패해도 나머지 결과를 보여줘야 할 때

// 이미지, 리소스 로딩 중 일부 오류 허용 시

// 데이터 파이프라인에서 부분 성공 처리