import { IMenuItem } from '../../interfaces'
import { FC } from 'react'

interface Props {
  item: IMenuItem
}

export const MenuItem: FC<Props> = ({ item }) => {
  return <h1>{item.name}</h1>
}
