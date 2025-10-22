const PromiseA = new Promise((resolve, reject)=>{
    resolve('return data');
});

PromiseA.then((data)=> console.log(data));

const PromiseB = new Promise((resolve, reject)=>{
    reject(new Error('return error'));
});
PromiseB.catch((err)=> console.log(err));

console.log('done');