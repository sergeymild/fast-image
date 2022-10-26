import React from 'react'
import { StyleSheet, View } from 'react-native'
import SectionFlex from './SectionFlex'
import FastImage from 'react-native-fast-image'
import Section from './Section'
import FeatureText from './FeatureText'


export const DefaultExample = () => {
    return (
        <View>
            <Section>
                <FeatureText text="• SVG support." />
            </Section>
            <SectionFlex >
                <FastImage
                    style={styles.image} source={{ uri: '' }}
                />
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
