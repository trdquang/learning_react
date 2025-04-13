import { useEffect, useState } from "react";
import { ProductService } from "../../services/ProductService";
import { log } from "node:console";
import { ProductSearch } from "../../dto/product/ProductSearch";

export default function Product() {
    const productService = new ProductService();
    const [searchDto, setSearchDto] = useState(
        new ProductSearch('', 1, 100, new Date().getTime())
    );
    const [productList, setproductList] = useState([])
    
    useEffect(() => {
        productService.getAll()
            .then((data) => {
                console.log('data = ', data);
                
                setproductList(data.content); 

            })
            .catch((err) => {
                console.log('lấy sản phẩm bị lỗi');
                
                console.error("Failed to fetch products", err);
            });
    }, []);
    
    
    return (
        <div>
        <h2>Danh sách sản phẩm</h2>
        <ul>
            {productList.map((product: any) => (
                <li key={product.id}>
                    {product.name} - {product.price}đ ({product.categoryName})
                </li>
            ))}
        </ul>
    </div>
    );
}