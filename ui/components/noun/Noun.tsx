import { FC } from 'react'
import { INoun } from '../../interfaces'

interface Props {
  noun: INoun
}

export const Noun: FC<Props> = ({ noun }) => {
  return (
    <>
      <h1>{noun.fullName}</h1>
      <h3>{noun.description}</h3>
      {noun.tags.map((tag) => `#${tag}`).join(' ')}
    </>
  )
}
