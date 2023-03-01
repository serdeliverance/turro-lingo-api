import { IMenuItem } from '../interfaces'
import {useEffect, useState} from "react";

export interface MenuItemsResponse {
  items: IMenuItem[]
  loading: boolean
}

// TODO implement
export const useMenuItems = (): MenuItemsResponse => {

  const [items, setItems] = useState<IMenuItem[]>([])

  const [loading, setLoading] = useState(false)

  useEffect(() => {
    setLoading(true)
  }, [])

  return {
    items,
    loading,
  }
}
