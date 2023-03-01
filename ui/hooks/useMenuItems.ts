import { IMenuItem } from '../interfaces'

export interface MenuItemsResponse {
  items: IMenuItem[]
  loading: boolean
}

// TODO implement
export const useMenuItems = (): MenuItemsResponse => ({
  items: [],
  loading: false,
})
