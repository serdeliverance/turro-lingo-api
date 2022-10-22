import React, { FC } from 'react'
import { IFlashCard } from '../interfaces'

interface Props {
    flashCard: IFlashCard
}

export const FlashCard: FC<Props> = ({ flashCard }) => {
  return (
    <div>{flashCard.front}</div>
  )
}
