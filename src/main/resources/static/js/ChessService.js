export default class ChessService {
    constructor() {
        this.baseUrl = "http://localhost:4567";
        this.headers = {
            "Content-Type": "application/json"
        };
    }

    async moveSourceToTarget(source, target) {
        return await fetch(`${this.baseUrl}/chessboard`, {
            method: "POST",
            headers: this.headers,
            body: JSON.stringify({source, target})
        });
    }

    async getChessBoard() {
        const response = await fetch(`${this.baseUrl}/chessboard`);
        return response.json();
    }

    async getResult() {
        const response = await fetch(`${this.baseUrl}/chessboard/result`);
        return response.json();
    }

}