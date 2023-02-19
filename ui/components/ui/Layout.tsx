import Head from 'next/head'
import { FC, ReactNode } from 'react'
import { Navbar } from '.'

interface Props {
  children: ReactNode
  title: string
}

export const Layout: FC<Props> = ({ children, title }) => {
  return (
    <>
      <Head>
        <title>{title}</title>
        <meta name="author" content="sd3v" />
        <meta
          name="description"
          content="Flashcard website for learning languages"
        />
        {/* TODO add more seo friendly meta tags. For example: og tags */}
      </Head>
      <Navbar />

      <main>{children}</main>
    </>
  )
}
