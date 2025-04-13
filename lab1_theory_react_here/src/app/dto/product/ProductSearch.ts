export class ProductSearch{
    keySearch: string
    page: number
    limit: number
    timer: number

    constructor(keySearch: string, limit: number, page: number, timer: number) {
        this.keySearch = keySearch;
        this.limit = limit;
        this.page = page;
        this.timer = timer;
    }
}