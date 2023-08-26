import { FC } from 'react'
import { INoun } from '../../interfaces'
import { Flashcard } from '../flashcard'

interface Props {
  noun: INoun
}

const getColorByArticle = (article: string) => {
    switch (article.toLowerCase()) {
        case 'der':
            return '#0872b9'
        case 'die':
            return '#ffb7ff'
        default:
            return '#a9a3a3'
    }
}

const BACK_COLOR = '#0c2020'

export const NounCard: FC<Props> = ({ noun }) => {
  const frontColor = getColorByArticle(noun.article)

  return (
    <>
      <Flashcard
        flashCard={{
          id: noun.id,
          front: noun.fullName,
          back: noun.description,
        }}
        frontColor={frontColor}
        backColor={BACK_COLOR}
      />
    </>
  )
}
