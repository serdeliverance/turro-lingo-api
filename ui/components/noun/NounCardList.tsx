import { FC } from 'react'
import { useNouns } from '../../hooks/useNouns'
import { NounCard } from './NounCard'
import { Grid } from '@mui/material'
import { Box } from '@mui/system'
import { INoun } from '../../interfaces'

interface Props {}

// TODO move to commons package
const capitalized = (s: string) => {
    if (s.length > 1) {
        return s.charAt(0).toUpperCase() + s.slice(1)
    }
    else return s.toUpperCase()
}

// TODO refactor: look for a more elegant way to do this
// maybe this method will be removed and instead, adding tag as a NounCardList property
const getTag = (nouns: INoun[]): string | null =>
  nouns.length > 0 && nouns[0].tags.length > 0 ? `#${capitalized(nouns[0].tags[0])}` : null

// TODO consider add tag as a NounCardList property and remove the method above
// TODO consider passing nouns as a parameter this component
export const NounCardList: FC<Props> = () => {
  const { nouns, loading } = useNouns()

  const tag: string | null = nouns ? getTag(nouns) : null

  if (loading) {
    return <h1>loading...</h1>
  }

  return (
    <Box flexGrow={1} marginLeft={5} marginRight={5}>
      {tag && <h1>{tag}</h1>}
      <Grid container spacing={2}>
        {nouns.map((noun) => (
          <NounCard noun={noun} />
        ))}
      </Grid>
    </Box>
  )
}
