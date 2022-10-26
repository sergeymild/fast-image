import React from 'react'
import { StyleSheet, View } from 'react-native'
import SectionFlex from './SectionFlex'
import FastImage from 'react-native-fast-image'
import Section from './Section'
import FeatureText from './FeatureText'
import { useCacheBust } from './useCacheBust'

const SVG_URL =
    'https://file-examples.com/storage/fed6cf172a635710f9f4051/2017/04/file_example_MP4_1920_18MG.mp4'

export const VideoThumbnailExample = () => {
    const { url, bust } = useCacheBust(SVG_URL)
    return (
        <View>
            <Section>
                <FeatureText text="• Video support." />
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
