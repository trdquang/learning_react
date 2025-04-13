import axios from "axios";


const  BASE_URL = process.env.REACT_APP_API_URL;
const  URL_GET_LIST_CATEGORY = `${BASE_URL}/products/list`;
const  URL_ADD_CATEGORY = `${BASE_URL}/products/add`;
const  URL_ADD_UPDATE = `${BASE_URL}/products/update`;
const  URL_ADD_DELETE = `${BASE_URL}/products/delete`;

export class ProductService{

    public async getAll(page: number = 1, limit: number = 75) {
        try {
            const response = await axios.get(URL_GET_LIST_CATEGORY, {
                params: {
                    page,
                    limit
                }
            });
            return response.data;
        } catch (error) {
            console.error("Error fetching products:", error);
        }
    }

    public async addProduct(product: any) {
        try {
            const response = await axios.post(URL_ADD_CATEGORY, product);
            return response.data;
        } catch (error) {
            console.error("Error adding product:", error);
        }
    }

    public async updateProduct(id: number, product: any) {
        try {
            const response = await axios.put(`${URL_ADD_UPDATE}/${id}`, product);
            return response.data;
        } catch (error) {
            console.error("Error updating product:", error);
        }
    }

    public async deleteProduct(id: number) {
        try {
            const response = await axios.delete(`${URL_ADD_DELETE}/${id}`);
            return response.data;
        } catch (error) {
            console.error("Error deleting product:", error);
        }
    }
    
}