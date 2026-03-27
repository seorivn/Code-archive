const fs = require('fs');
let input = fs.readFileSync(0).toString().trim().split('\n');
let N = Number(input.shift());
let board = input.map(e => e.split('').map(Number));
let result = [];

let dxs = [0, 1, 0, -1];
let dys = [1, 0, -1, 0];
let visited = Array.from({length: N}, () => Array(N).fill(false));

function dfs(x,y) {
    let size = 1;
    let queue = [[x, y]];
    visited[x][y] = true;

    while (queue.length > 0) {
        let [dx, dy] = queue.pop();
        for (let d = 0; d<4; d++) {
            let nx = dx+dxs[d];
            let ny = dy+dys[d];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && board[nx][ny] === 1) {
                queue.push([nx, ny]);
                visited[nx][ny] = true;
                size++;
            }
        }
    }
    return size;
}

for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
        if (!visited[i][j] && board[i][j] === 1) {
            result.push(dfs(i, j));
        }
    }
}

console.log(result.length)
console.log(result.sort((a,b) => a-b).join('\n'));