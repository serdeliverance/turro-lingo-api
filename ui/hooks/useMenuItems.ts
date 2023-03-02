import { IMenuItem } from '../interfaces'
import useSWR from 'swr'

export interface MenuItemsResponse {
  items: IMenuItem[]
  error: string
  loading: boolean
}

export const useMenuItems = (): MenuItemsResponse => {

  // TODO get host from env variable
  const { data, error, isLoading } = useSWR('http://localhost:8080/api/menus')

  return {
    items: data,
    error,
    loading: isLoading,
  }
}
