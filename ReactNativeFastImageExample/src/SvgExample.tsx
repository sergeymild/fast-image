import React from 'react'
import { StyleSheet, View } from 'react-native'
import SectionFlex from './SectionFlex'
import FastImage from 'react-native-fast-image'
import Section from './Section'
import FeatureText from './FeatureText'
import { useCacheBust } from './useCacheBust'

const SVG_URL =
    'https://liquidifty-external.imgix.net/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1cmwiOiJodHRwczovL29wZW5zZWF1c2VyZGF0YS5jb20vZmlsZXMvZDVmNzkzM2FlNjkzYzI5OGJjZGRmMWNlYzViNWZlYTkuc3ZnIn0.NB2wxIdjrobCb3pOYxAUiBqXzs9hlsIOAMD95-xvpxc?w=250&h=400&auto=format,compress&q=30'

export const SvgExample = () => {
    const { url, bust } = useCacheBust(SVG_URL)
    return (
        <View>
            <Section>
                <FeatureText text="• SVG support." />
            </Section>
            <SectionFlex onPress={bust}>
                <FastImage style={styles.image} source={{ uri: url }} />
            </SectionFlex>
        </View>
    )
}

const styles = StyleSheet.create({
    image: {
        backgroundColor: '#ddd',
        margin: 20,
        height: 100,
        width: 100,
        flex: 0,
    },
})
