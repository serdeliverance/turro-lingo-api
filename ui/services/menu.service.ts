import {IMenuItem} from "../interfaces";
import axios from "axios";

const getMenuItems = async (): Promise<IMenuItem[]> => {
    // TODO parameterize server host
    const response = await axios.get<IMenuItem[]>(
        `http://localhost:8080/api/menus`,
    )
    return response.data
}

// TODO define deck service as interface so I can have mock implementations for test
const MenuService = {
    getMenuItems,
}

export default MenuService